import { Button} from '@mui/material';
import React from 'react';
import {Link} from "react-router-dom";
import DeleteIcon from '@mui/icons-material/Delete';

function DeleteTaskForm(props) {

    function DeleteTask(e) {
        e.preventDefault();
        const task = {
        
        };
        props.DeleteTask(task);
        
    };

    return (
        <section >
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>Back to my Tasks</Link>
                </Button>
            </div>
            <form onSubmit={DeleteTask}>
                <h2>Are you sure you want to delete this task? </h2>
                    <br></br>
                <Button type='submit' variant='outlined' startIcon={<DeleteIcon />}>
                    Delete Task
                </Button>
            </form>
            
                
            
        </section>
    );
};

export default DeleteTaskForm;
