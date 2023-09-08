import React from "react";
import { useHistory } from 'react-router-dom';
import DeleteTaskForm from "../components/DeleteTaskForm";

function DeleteTask()  {
    const history = useHistory();
    function DeleteTaskHandler(task) {
        //the below loc is where I want to dump the data
        let id = history.location.pathname.split('/')[2];
        
            fetch('http://localhost:9001/task/delete/?id='+ id, {
            method:'DELETE',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
             }

    }).then(() => history.replace('/tasks'));
}

    return (
        <DeleteTaskForm  DeleteTask ={DeleteTaskHandler}/>
    );


};

export default DeleteTask;
