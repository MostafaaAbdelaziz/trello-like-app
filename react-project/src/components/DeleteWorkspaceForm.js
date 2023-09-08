import { Button } from '@mui/material';
import React from 'react';
import {Link} from "react-router-dom";
import DeleteIcon from '@mui/icons-material/Delete';

function DeleteWorkspaceForm(props) {
    function DeleteWorkspace(e) {
        e.preventDefault();

        const workspace = {
        };
        props.DeleteWorkspace(workspace);
    };

    return (
        <section>
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/workspaces" style={{textDecoration: 'none', color: 'white'}}>Back to my Workspaces</Link>
                </Button>
            </div>
            <form onSubmit={DeleteWorkspace}>
                <h2>Are you sure you want to delete this workspace? </h2>
                    <br></br>
                <Button type='submit' variant='outlined' startIcon={<DeleteIcon />}>
                    Delete Workspace
                </Button>
            </form>
          
                
            
        </section>
    );
};

export default DeleteWorkspaceForm;
