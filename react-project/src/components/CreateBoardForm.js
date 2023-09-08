import { Button, TextField, Typography } from '@mui/material';
import React from 'react';
import { useRef } from 'react';
import {Link} from "react-router-dom";

function CreateBoardForm(props) {
    const boardNameRef = useRef();
    const boardDespRef = useRef();

    function CreateBoard(e) {
        e.preventDefault();
        const boardName = boardNameRef.current.value;
        const boardDesp = boardDespRef.current.value;

        const board = {
            name: boardName,
            description: boardDesp
        };

        props.CreateBoard(board);
    };

    return (
        <section >
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/boards" style={{textDecoration: 'none', color: 'white'}}>Back to my Boards</Link>
                </Button>
            </div>
            <Typography variant='h2' component='h2'>Create New Board</Typography>
            <form onSubmit={CreateBoard}>
                <TextField
                    id='boardName'
                    placeholder='Board Name'
                    variant='outlined'
                    required
                    margin='dense'
                    inputRef={boardNameRef} />
                <TextField
                    id='boardDesp'
                    placeholder='Board Description'
                    variant='outlined'
                    multiline
                    rows={4}
                    required
                    fullWidth
                    margin='dense'
                    inputRef={boardDespRef} />
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Board
                </Button>
                
                
           
            </form>
            
        </section>
    );
};

export default CreateBoardForm;
