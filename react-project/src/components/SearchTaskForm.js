import { Button, TextField } from "@mui/material";
import React from "react";
import { useRef } from "react";
import { Link } from "react-router-dom";

function SearchTaskForm (props) {
    const SearchTaskRef = useRef();

    function SearchTask(e) {
        e.preventDefault();
        const Search = SearchTaskRef.current.value;

        const search = {
            search: Search
        };
        props.SearchTask(search);
    };

    return (
        <section>
                <div align= "left">
                <Button type='submit' variant='contained' color='primary'>
                    <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>⬅ Back to my Tasks</Link>
                </Button>
                </div>
                <form onSubmit={SearchTask}>
                <h1>Please enter the name of the task you wish to find :</h1>
                <TextField
                    id='search'
                    variant='outlined'
                    margin='dense'  
                    inputRef={SearchTaskRef} />
                <br></br>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Search
                </Button>
                
            </form>
        </section>
    );
}
    export default SearchTaskForm;