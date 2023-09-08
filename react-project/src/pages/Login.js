import { useHistory } from "react-router-dom";
import React from "react";
import LoginForm from "../components/LoginForm";

function LoginPage(){

    const history = useHistory();

    function loginUserHandler(user){
        fetch('http://localhost:9001/user/getUserByEmail?email='+user.email)
        .then((response)=> response.json())
        .then((data) => {
            //user autheenticationed here

            if(user.email === data.email && user.password === data.password){
                localStorage.setItem('user', "Authenticated");
                window.location.reload();
                history.replace('/home');
                window.location.reload();
            }
            else{
                localStorage.setItem('user', "notAuthenticated");
                alert("Invalid email or password, please try again");
                return;
            }
        })
    }
    
    return(
        <div>
            <h1 className="nav">Login Page</h1>
            <LoginForm loginUser={loginUserHandler }/>
        </div>//semantic HTML, nav at top, diff sections, 
    );
}
export default LoginPage;  