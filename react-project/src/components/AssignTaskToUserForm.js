import { Button, TextField, Typography } from '@mui/material';
import React from 'react';
import { useRef } from 'react';
import {Link} from "react-router-dom";

function AssignTaskToUserForm(props) {
    const UserEntered = useRef();

    function AssignTaskToUser(e) {
        e.preventDefault();
        const userEnteredValue = UserEntered.current.value;

        const board = {
            value: userEnteredValue,
   
        };

        props.AssignTaskToUser(board);
    };

    return (
        <section >
            <div align= "left">
            <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/boards" style={{textDecoration: 'none', color: 'white'}}>Back to my Boards</Link>
                </Button>
            </div>
            <Typography variant='h2' component='h2'>Assign Task to User</Typography>
            <form onSubmit={AssignTaskToUser}>
                <TextField
                    id='userEnteredValue'
                    placeholder='ID or Email of User'
                    variant='outlined'
                    required
                    margin='dense'
                    inputRef={UserEntered} />
                    <br></br>
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Assign To User
                </Button>
                
            </form>
            
        </section>
    );
};

export default AssignTaskToUserForm;
