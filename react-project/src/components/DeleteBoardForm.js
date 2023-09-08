import { Button } from '@mui/material';
import React from 'react';
import {Link} from "react-router-dom";
import DeleteIcon from '@mui/icons-material/Delete';



function DeleteBoardForm(props) {

    function DeleteBoard(e) {
        e.preventDefault();
        const board = {
        
        };
        props.DeleteBoard(board);
        
    };

    return (
        <section >
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/boards" style={{textDecoration: 'none', color: 'white'}}>Back to my Boards</Link>
                </Button>
            </div>
            <form onSubmit={DeleteBoard}>
                <h2>Are you sure you want to delete this board? </h2>
                    <br></br>
                <Button type='submit' variant="outlined" startIcon={<DeleteIcon />}>
                    Delete Board
                </Button>
            </form>
         
                
          
        </section>
    );
};

export default DeleteBoardForm;
