import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateWorkspaceForm from '../components/CreateWorkspaceForm';


function CreateWorkspace() {

    const history = useHistory();

    function createWorkspaceHandler(workspace) {
        fetch('http://localhost:9001/workspace', {
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(workspace),
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
            
        }).then(() => history.replace('/workspaces'));
    }

    return (
        <CreateWorkspaceForm CreateWorkspace={createWorkspaceHandler} />
    );
};

export default CreateWorkspace;