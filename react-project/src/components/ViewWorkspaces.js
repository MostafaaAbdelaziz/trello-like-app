import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';


function ViewWorkspaces(props) {
        return (
        <>
        <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
            <Card elevation={20}>
                <CardContent>
                    <section>
                         <div align= "left">
                        <Button variant='contained' href="/home">
                        ⬅ back to home
                        </Button>
                        </div>
                        <Typography variant='h2' component='h2'>My Workspaces</Typography>
                        <Button variant='contained' href="/create-workspace" sx={{ marginTop: '16px' , marginBottom: '10px', marginRight: '10px'}}>
                        + create a new workspace
                        </Button>
                        <Grid container spacing={2}>
                            {props.workspaces.map((workspace) => {
                                return (
                                    <Grid item xs={12} sm={12} md={4} lg={4} key={workspace.id}>
                                        <Card elevation={6}>
                                            <CardContent>
                                                <Typography component='h4' variant='h4'>
                                                    {workspace.workspaceName}
                                                </Typography>
                                                <Typography component='p' variant='p'>
                                                    {workspace.description}
                                                </Typography>
                                                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                                                    <Link to = "/boards" style={{textDecoration: 'none', color: 'white'}}>View all Boards</Link>
                                                </Button>
                                            
                                                <br></br>
                                                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                                                    <Link to = {"/delete-workspace/" + workspace.id} style={{textDecoration: 'none', color: 'white'}}>Delete Workspace</Link>
                                                </Button>
                                            </CardContent>
                                        </Card>
                                    </Grid>
                                );
                            })}
                        </Grid>
                    </section>
                </CardContent>
            </Card>
        </Grid>
        </>
    );
};

export default ViewWorkspaces;