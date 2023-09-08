// import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { Link } from 'react-router-dom';
import * as React from 'react';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import Box from '@mui/material/Box';
import {IconButton} from '@mui/material';

function ViewTasks(props) {

        return (
        <>
        <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
            <Card elevation={20}>
                <CardContent>
                    <section>
                    <div align= "left">
                        <Button variant='contained' href="/boards">
                        ⬅ back to my boards
                        </Button>
                        </div>
                        <Typography variant='h2' component='h2'>My Tasks</Typography>
                        
                        <Button variant='contained' href="/create-task" sx={{ marginTop: '16px' , marginBottom: '10px', marginRight: '10px'}}>
                        + create a new task
                        </Button>
                       
                        <IconButton type='submit' variant='contained' href="/search-task" sx={{ marginTop: '16px' , marginBottom: '10px', marginRight: '10px'}}>
                            Search...
                        </IconButton>
                       
                            {props.tasks.map((task) => {
                                return (
                                    <>
                                    <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
                                        <Card elevation={20}>
                                            <CardContent>
                                                    <Card elevation={6}>
                                                        <CardContent>
                                                            <Typography component='h4' variant='h4' align="left">
                                                                {task.taskName}
                                                            </Typography>
                                                            <Typography component='h6' variant='h6' align="left" color="1976d2" fontWeight={"bold"}>
                                                                Status: {task.taskStatus}
                                                            </Typography>
                                                            <Typography component='h6' variant='h6' align="left" color="1976d2" fontWeight={"bold"}>
                                                                Due Date: {task.taskDueDate}
                                                                <br></br>
                                                                
                                                            </Typography>
                                                            <div align= "right">
                                                                <Box component="span" sx={{ p: 2, border: 'none' }} >
                                                                <Button variant="outlined" href= {"/set-due-date/" + task.id} color="success">
                                                                        Change Due Date
                                                                </Button>
                                                                &nbsp;
                                                                    <Button variant="contained" href= {"/update-task/" + task.id} color='primary'>
                                                                        Edit Status
                                                                    </Button>
                                                                    {/* <Button variant='contained' href= {"/task-date/" + task.id} color='primary'>
                                                                        Edit Date
                                                                    </Button> */}
                                                                    &nbsp;
                                                                    <Button variant="contained" href= {"/assign-task-to-user/" + task.id} color="success">
                                                                        Assign this task to a user
                                                                    </Button>
                                                                    &nbsp;
                                                                    <Button variant="outlined" startIcon={<DeleteIcon />}>
                                                                        <Link to = {"/delete-task/" + task.id} style={{textDecoration: 'none', color: '1976d2'}}>Delete Task</Link>
                                                                    </Button>
                                                                </Box>
                                                            </div>
                                                        </CardContent>
                                                    </Card>
                                                </CardContent>
                                            </Card>
                                        </Grid>
                                        </>
                                );
                            })}
                    </section>
                    </CardContent>
                </Card>
            </Grid>
        </>
    );
};

export default ViewTasks;