import React from 'react';
import {Link} from "react-router-dom";
import { Box, AppBar, Toolbar, Typography } from '@mui/material';

function NavigationLogin() {
    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar>
                    <Link to='/login' style={{ textDecoration: 'none', color: 'white' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 8px' }}>
                            Login
                        </Typography>
                    </Link>
                    <Link to='/register' style={{ textDecoration: 'none', color: 'white' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 8px' }}>
                            Register
                        </Typography>
                    </Link>
                    <Link to='/forgetpass' style={{ textDecoration: 'none', color: 'white' }}>
                        <Typography variant="h6" component="div" sx={{ padding: '0 8px' }}>
                            Forget Password
                        </Typography>
                    </Link>

                </Toolbar>
            </AppBar>
        </Box>
    );
}

export default NavigationLogin;