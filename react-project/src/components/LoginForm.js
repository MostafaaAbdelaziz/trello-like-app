import React, {useRef} from "react";
import {Link} from "react-router-dom";


function LoginForm (props) {


    const emailRef = useRef();
    const passwordRef = useRef();
    //fetch allows to call an API and send to back-end

    function submitHandler(event){
        event.preventDefault(); //this way the page will not be refreshed
        //1. read the values
        const email = emailRef.current.value;
        const password = passwordRef.current.value; 
        //call spring boot and get the email with the pass

        const user = {email, password};
        // console.log(user);
        //2. save values to database

        //call registerUserHandler
        props.loginUser(user); 

    }

    return (
        <form onSubmit={submitHandler}>
            <input className="placeHolder" type="email" required placeholder="Email" ref={emailRef}/>
            <br></br>
            <br></br>
            <input className="placeHolder" type="password" required placeholder="Password" ref={passwordRef}/>
            <br></br>
            <br></br>
            <button className="buttons"><h2>Sign in</h2></button>
            <br></br>
            <br></br>
                <Link to='/forgetpass'>
                   <input type={"button"} value="Forgot password?" className="buttons"/>
                </Link>
        
        </form>
    );
}
export default LoginForm;