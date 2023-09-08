import React from 'react';
import { useHistory } from 'react-router-dom';
import AssignTaskToUserForm from '../components/AssignTaskToUserForm';


function AssignTaskToUser() {

    const history = useHistory();
    
    function AssignTaskToUserHandler(e) {
        let taskId = history.location.pathname.split('/')[2];
        let userEnteredValue = e["value"];
        let url = "http://localhost:9001/task/assign/" + taskId +"/user";

        if (!isNaN(userEnteredValue)) {
            url = url + "?id=" + userEnteredValue
        } else {
            url = url 
            + "?email=" + userEnteredValue
        }
        fetch(url, {
            method: 'PUT',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
            
        }).then(() => history.replace('/tasks'));
    }

    return (
        <AssignTaskToUserForm AssignTaskToUser={AssignTaskToUserHandler} />
    );
};

export default AssignTaskToUser;