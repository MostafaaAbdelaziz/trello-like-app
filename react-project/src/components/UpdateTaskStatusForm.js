import { Button, TextField } from '@mui/material';
import React from 'react';
import { useRef } from 'react';
import {Link} from "react-router-dom";

function UpdateTaskStatusForm(props) {
    const TaskStatusRef = useRef();

    function UpdateTaskStatus(e) {
        e.preventDefault();
        const TaskStatus = TaskStatusRef.current.value;

        const taskStatus = {
            taskStatus: TaskStatus
        };
        props.UpdateTaskStatus(taskStatus);
    };

    return (
        <section>
                <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>Back to my Tasks</Link>
                </Button>
                </div>
            <form onSubmit={UpdateTaskStatus}>
                <h1>Please set the status to one of the following :</h1>
                <h3> To Do , In Progress , Done</h3>
                <TextField
                    id='taskStatus'
                    variant='outlined'
                    margin='dense'
                    inputRef={TaskStatusRef} />
                <br></br>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Update Status
                </Button>
                <br></br>
                
            </form>            
        </section>
    );
};

export default UpdateTaskStatusForm;
