import React, { useEffect, useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import {
    Card,
    Grid,
    Typography,
    TextField,
} from "@mui/material";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

const Search = () => {
    const [posts, setPosts] = useState([]);
    const [keyword, setKeyword] = useState("");
    const navigate = useNavigate();

    const handleEdit = (id) => {
        navigate("/edit", { state: { id } });
    };

    const fetchInitialPosts = async () => {
        const response = await axios.get('http://localhost:8080/jobPosts');
        setPosts(response.data);
    };

    const fetchFilteredPosts = async (keyword) => {
        const response = await axios.get(`http://localhost:8080/jobPost/keyword/${keyword}`);
        setPosts(response.data);
    };

    useEffect(() => {
        fetchInitialPosts();
    }, []);

    useEffect(() => {
        if (keyword) {
            fetchFilteredPosts(keyword);
        } else {
            fetchInitialPosts();
        }
    }, [keyword]);

    const handleDelete = async (id) => {
        await axios.delete(`http://localhost:8080/jobPost/${id}`);
        fetchInitialPosts();
    };

    return (
        <>
            <Grid container spacing={1} sx={{ margin: "2%" }}>
                <Grid item xs={12}>
                    <TextField
                        label="Search Job's"
                        
                        variant="outlined"
                        value={keyword}
                        onChange={(e) => setKeyword(e.target.value)}
                        sx={{ marginRight: "1%", marginBottom: "2%",width:"80%"}}
                        fullWidth
                      
                    />
                </Grid>
                {posts.map((p) => (
                    <Grid key={p.id} item xs={12} md={6} lg={4}>
                        <Card sx={{ padding: "3%", overflow: "hidden", width: "80%", backgroundColor: "#ADD8E6" }}>
                            <Typography
                                variant="h5"
                                sx={{ fontSize: "2rem", fontWeight: "600", fontFamily: "sans-serif" }}
                            >
                                {p.postProfile}
                            </Typography>
                            <Typography sx={{ color: "#585858", marginTop: "2%", fontFamily: "cursive" }} variant="body">
                                Description: {p.postDesc}
                            </Typography>
                            <br />
                            <br />
                            <Typography variant="h6" sx={{ fontFamily: "unset", fontSize: "400" }}>
                                Experience: {p.reqExperience} years
                            </Typography>
                            <Typography sx={{ fontFamily: "serif", fontSize: "400" }} gutterBottom variant="body">Skills :</Typography>
                            {p.postTechStack.map((s, i) => (
                                <Typography variant="body" gutterBottom key={i}>
                                    {s}.
                                    {` `}
                                </Typography>
                            ))}
                            <DeleteIcon onClick={() => handleDelete(p.postId)} />
                            <EditIcon onClick={() => handleEdit(p.postId)} />
                        </Card>
                    </Grid>
                ))}
            </Grid>
        </>
    );
};

export default Search;
