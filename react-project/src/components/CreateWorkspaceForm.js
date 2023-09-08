import { Button, TextField, Typography } from '@mui/material';
import React from 'react';
import { useRef } from 'react';
import {Link} from "react-router-dom";

function CreateWorkspaceForm(props) {
    const WorkspaceNameRef = useRef();
    const WorkspaceDespRef = useRef();

    function CreateWorkspace(e) {
        e.preventDefault();
        const WorkspaceName = WorkspaceNameRef.current.value;
        const WorkspaceDesp = WorkspaceDespRef.current.value;

        const workspace = {
            workspaceName: WorkspaceName,
            description: WorkspaceDesp
        };
        props.CreateWorkspace(workspace);
    };

    return (
        <section>
            <div align= "left">
            <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                  <Link to = "/workspaces" style={{textDecoration: 'none', color: 'white'}}>Back to my Workspaces</Link>
            </Button>
            </div>
        
            <Typography variant='h2' component='h2'>Create New Workspace</Typography>
            <form onSubmit={CreateWorkspace}>
                <TextField
                    id='workspaceName'
                    placeholder='Workspace Name'
                    variant='outlined'
                    required
                    margin='dense'
                    inputRef={WorkspaceNameRef} />
                <TextField
                    id='workspaceDesp'
                    placeholder='Workspace Description'
                    variant='outlined'
                    multiline
                    rows={4}
                    required
                    fullWidth
                    margin='dense'
                    inputRef={WorkspaceDespRef} />
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Workspace
                </Button>
            </form>
            
        </section>
    );
};

export default CreateWorkspaceForm;
