import React, { useEffect, useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

const initial = {
  postId: "",
  postProfile: "",
  reqExperience: 0,
  postTechStack: [],
  postDesc: "",
};

const Edit = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [form, setForm] = useState(initial);
  const [currId] = useState(location.state.id);

  useEffect(() => {
    const fetchInitialPosts = async (id) => {  
      try {
        const response = await axios.get(`http://localhost:8080/jobPost/${id}`);
        console.log(response.data);
        setForm(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchInitialPosts(currId);
  }, [currId]);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios     
      .put("http://localhost:8080/jobPost", form)
      .then((resp) => {
        console.log(resp.data);
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleChange = (e) => {
    const skill = e.target.value;
    setForm((prevForm) => {
      const updatedSkills = prevForm.postTechStack.includes(skill)
        ? prevForm.postTechStack.filter((item) => item !== skill)
        : [...prevForm.postTechStack, skill];

      return { ...prevForm, postTechStack: updatedSkills };
    });
  };

  const skillSet = [
    { name: "Javascript" },
    { name: "Java" },
    { name: "Python" },
    { name: "Django" },
    { name: "Rust" },
    { name: "HTML" },
    { name: "CSS" },
    { name: "TypeScript" },
    { name: "React.js" },
    { name: "Angular" },
    { name: "Vue.js" },
    { name: "SASS" },
    { name: "Bootstrap" },
    { name: "Tailwind CSS" },
    { name: "Material-UI" },
    { name: "Redux" },
    { name: "Node.js" },
    { name: "Express.js" },
    { name: "Spring Boot" },
    { name: "Flask" },
    { name: "Ruby on Rails" },
    { name: "PHP" },
    { name: "Laravel" },
    { name: "C#" },
    { name: ".NET Core" },
    { name: "Golang" },
    { name: "Kotlin" },
    { name: "MySQL" },
    { name: "PostgreSQL" },
    { name: "MongoDB" },
    { name: "Redis" },
    { name: "Docker" },
    { name: "Kubernetes" },
    { name: "AWS" },
    { name: "Azure" },
    { name: "Google Cloud Platform" }
];


  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Update Job Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setForm({ ...form, postId: e.target.value })}
            label="Enter your Post ID"
            variant="outlined"
            value={form.postId}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label="Job-Profile"
            variant="outlined"
            value={form.postProfile}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, reqExperience: e.target.value })}
            label="Years of Experience"
            variant="outlined"
            value={form.reqExperience}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={(e) => setForm({ ...form, postDesc: e.target.value })}
            label="Job-desc"
            variant="outlined"
            value={form.postDesc}
          />
          <Box sx={{ margin: "1% auto" }}>
            <Typography variant="h6">Please mention required skills</Typography>
            <ul>
              {skillSet.map(({ name }, index) => (
                <li key={index}>
                  <div>
                    <input
                      type="checkbox"
                      id={`custom-checkbox-${index}`}
                      name={name}
                      value={name}
                      checked={form.postTechStack.includes(name)}
                      onChange={handleChange}
                    />
                    <label htmlFor={`custom-checkbox-${index}`}>
                      {name}
                    </label>
                  </div>
                </li>
              ))}
            </ul>
          </Box>
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Edit;
