import React, {useRef, useState} from "react";
import validator from 'validator';

function ForgetPass (props) {
    const [errorMessage, setErrorMessage] = useState('')
 
    const validate = (value) => {

    if (validator.isStrongPassword(value, {
    minLength: 8, minLowercase: 1,
    minUppercase: 1, minNumbers: 1, minSymbols: 1
     })){
        setErrorMessage(null);
    } else {
        setErrorMessage('Is Not Strong Password');
    }
}

    const emailRef = useRef();
    const securityQuestion1Ref = useRef();
    const securityQuestion2Ref = useRef();
    const newPasswordRef = useRef();
    //fetch allows to call an API and send to back-end

    function submitHandler(event){
        event.preventDefault(); //this way the page will not be refreshed
        //1. read the values

        const email = emailRef.current.value;
        const securityQuestion1 = securityQuestion1Ref.current.value;
        const securityQuestion2 = securityQuestion2Ref.current.value;
        const newPassword = newPasswordRef.current.value;
        if (errorMessage === 'Is Not Strong Password'){
          alert('Please enter a strong password with at least 8 characters, 1 lowercase letter, 1 uppercase letter, 1 number and 1 symbol');
          return;
        }
        const user = { email, securityQuestion1, securityQuestion2,newPassword};
        
        //console.log(user);
        //2. save values to database

        //call registerUserHandler
        props.forgetingPassword(user);
    }

    return (
        <form className = "registerCSS" onSubmit={submitHandler}>   
            <div className="placeHolder">Email</div>
            <input type="email"className="placeHolder" required placeholder="example@email.com" ref={emailRef}/>
            <div className="placeHolder">What was your first car?</div>
            <input type="text"className="placeHolder" required placeholder="Security Question #1" ref={securityQuestion1Ref}/>
            <div className="placeHolder">What is your favorite color?</div>
            <input type="text"className="placeHolder" required placeholder="Security Question #2" ref={securityQuestion2Ref}/>
            <div className="placeHolder">New password</div>
            <input className="placeHolder" type="password" required placeholder="Enter Password" ref={newPasswordRef} onChange={(e) => validate(e.target.value)}></input>
            {errorMessage === '' ? null :
            <div className = "placeHolderError">{errorMessage}</div>}
            <br></br>
            {/* 
            got help from https://www.geeksforgeeks.org/how-to-validate-password-is-strong-or-not-in-reactjs/
            date accessed: 2022-06-06
            */}
            <br></br>
            <button className="buttons"><h2>Submit</h2></button>
        </form>
    );
}
export default ForgetPass;