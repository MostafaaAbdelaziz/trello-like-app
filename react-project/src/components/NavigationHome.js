import { useHistory } from 'react-router-dom';
import Button from '@mui/material/Button';

function NavigationHome() {

    const history = useHistory();

    function logoutUserHandler(user){

        console.log("LogoutPageT2");
        localStorage.setItem('user', "notAuthenticated");
        window.location.reload();
        history.replace('/login');
        window.location.reload();

    }

    return (
        <>
        <div align= "right">
            <Button variant="contained" color="error" onClick={logoutUserHandler}
            sx={{ marginTop: '16px' }}>Logout</Button>
        </div>
        </>
    );
}

export default NavigationHome;