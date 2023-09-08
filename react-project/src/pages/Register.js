import RegisterForm from "../components/RegisterForm";
import { useHistory } from "react-router-dom";
function  RegisterPage(){
    const history = useHistory();

    function  registerUserHandler(user) {
        //the below loc is where I want to dump the data
        fetch ('http://localhost:9001/user/save/', {
            method: 'POST',
            body: JSON.stringify(user), 
            headers: {'Content-Type': 'application/json'}
        }).then(()=> history.replace('/login'));//return
        //call the API
        //show log-in page
        //js provides and react uses fetch 
    }

    return(
        <div>
            <h1 className="nav">Registration Page</h1>
            <RegisterForm anyKeyUser={registerUserHandler}/>
        </div>
    );
 }

export default RegisterPage;