import {Link} from "react-router-dom";
import {Button } from '@mui/material';
import { Grid, Card, CardContent } from '@mui/material';

function HomePage(){
    return(
        <div>
        <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
            <Card elevation={20}>
                <CardContent>
                    <Grid item padding="2%" xs={12} sm={12} md={4} lg={4}>
                        <Card elevation={20}>
                            <CardContent>
                                <h1>Homepage</h1>
                                <h2>Welcome</h2>
                                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                                        <Link to = "/workspaces" style={{textDecoration: 'none', color: 'white'}}>Go to your workspaces ➡</Link>
                                </Button>
                                <br></br>
                            </CardContent>
                        </Card>
                    </Grid>
                </CardContent>
            </Card>
        </Grid>
        </div>
        
    );
}

export default HomePage;  