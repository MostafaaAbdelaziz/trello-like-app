import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';



function ViewBoards(props) {
        return (
        <>
        <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
            <Card elevation={20}>
                <CardContent>
                    <section>
                        <div align= "left">
                        <Button variant='contained' href="/workspaces">
                        ⬅ back to my workspaces
                        </Button>
                        </div>
                        <Typography variant='h2' component='h2'>My Boards</Typography>
                        <Button variant='contained' href="/create-board" sx={{ marginTop: '16px' , marginBottom: '10px', marginRight: '10px'}}>
                         + create a new board
                        </Button>
                        <Grid container spacing={2}>
                            {props.boards.map((board) => {
                                return (
                                    <Grid item xs={12} sm={12} md={4} lg={4} key={board.id}>
                                        <Card elevation={6}>
                                            <CardContent>
                                                <Typography component='h4' variant='h4'>
                                                    {board.name}
                                                </Typography>
                                                <Typography component='p' variant='p'>
                                                    {board.description}
                                                </Typography>
                                                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                                                    <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>View all Tasks</Link>
                                                </Button>
                                                <br></br>
                                                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                                                    <Link to = {"/delete-board/" + board.id} style={{textDecoration: 'none', color: 'white'}}>Delete Board</Link>
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

export default ViewBoards;