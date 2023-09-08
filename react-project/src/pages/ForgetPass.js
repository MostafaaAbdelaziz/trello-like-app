import ForgetPassForm from "../components/ForgetPassForm";
import { useHistory } from "react-router-dom";
function  ForgetPassPage(){
    const history = useHistory();

    function  forgetPassHandler(user) {
        //the below loc is where I want to dump the data
        fetch ('http://localhost:9001/user/getUserByEmail?email='+user.email, {
            method: 'GET',
            headers: {'Content-Type': 'application/json'}
        })
        .then(
            response => {
                return response.json();
                })
        .then(data => {
            //user autheenticationed here
            if(data.email === user.email && data.securityQuestion1 === user.securityQuestion1 && data.securityQuestion2 === user.securityQuestion2){
                //replace current password with new password
                fetch ('http://localhost:9001/user/newPassControl?email='+user.email+'&newPassword='+user.newPassword, {
                    method: 'POST',
                    mode: 'cors',
                    body: JSON.stringify(user),
                    headers: {'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'},
                }).then(responseInside => {
                    responseInside.json();
                })
            
                .then(dataInside => {
                    console.log(dataInside);
                    data.password = user.newPassword
                    alert("Password updated successfully");
                    history.replace('/login');
                }
                );
            }
            else{
                alert("Invalid security questions or email, please try again");
                return;
            }
        }
        )    
        // return
        // .then(data => setPostId(data.id));
        //call the API
        //show log-in page
        //js provides and react uses fetch 
        };
    return(
        <div>
            <h1 className="placeHolder">Forget Password Page</h1>
            <ForgetPassForm forgetingPassword={forgetPassHandler}/>
        </div>
    );
 }

export default ForgetPassPage;