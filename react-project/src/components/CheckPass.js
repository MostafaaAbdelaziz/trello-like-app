import React, {useRef, useState} from "react";
import validator from 'validator';

function CheckPass () {
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
}
export default CheckPass;