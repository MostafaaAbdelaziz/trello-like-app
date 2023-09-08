import { Button, TextField, Typography } from '@mui/material';
import React from 'react';
import { useRef } from 'react';
import {Link} from "react-router-dom";

function CreateTaskForm(props) {
    const taskNameRef = useRef();

    function CreateTask(e) {
        e.preventDefault();
        const tasksName = taskNameRef.current.value;

        const task = {
            taskName: tasksName,
        };

        props.CreateTask(task);
    };

    return (
        <section>
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>Back to my Tasks</Link>
                </Button>
            </div>
            <Typography variant='h4' component='h4' fontWeight={"bold"}>Please enter the name of the task you wish to create :</Typography>
            <br></br>
            <form onSubmit={CreateTask}>
                <TextField
                    id='taskName'
                    placeholder='Task Name'
                    variant='outlined'
                    required
                    margin='dense'
                    inputRef={taskNameRef} />
                <br></br>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Task
                </Button>
                <form>
            </form>
            </form>
            
        </section>
    );
};

export default CreateTaskForm;
