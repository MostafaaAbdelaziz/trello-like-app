import React from 'react';
import { useHistory } from 'react-router-dom';
import UpdateTaskStatusForm from '../components/UpdateTaskStatusForm';


function UpdateTaskStatus() {

    const history = useHistory();
    let id = history.location.pathname.split('/')[2];

    function updateTaskStatusHandler(status) {
        fetch('http://localhost:9001/task/updateTaskStatus/' + id, {
            method: 'PUT',
            mode: 'cors',
            body: JSON.stringify(status),
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
            
        }).then(() => history.replace('/tasks'));
    }

    return (
        <UpdateTaskStatusForm UpdateTaskStatus={updateTaskStatusHandler} />
    );
};

export default UpdateTaskStatus;