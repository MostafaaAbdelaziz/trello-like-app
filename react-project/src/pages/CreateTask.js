import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateTaskForm from '../components/CreateTaskForm';


function CreateTask() {

    const history = useHistory();

    function createTaskHandler(task) {
        fetch('http://localhost:9001/task', {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
            
        }).then(() => history.replace('/tasks'));
    }

    return (
        <CreateTaskForm CreateTask={createTaskHandler} />
    );
};

export default CreateTask;