import React from "react";
import { useHistory } from 'react-router-dom';
import DeleteWorkspaceForm from "../components/DeleteWorkspaceForm";

function DeleteWorkspace()  {
    const history = useHistory();
    function DeleteWorkspaceHandler(workspace) {
        //the below loc is where I want to dump the data
        let id = history.location.pathname.split('/')[2];
        
            fetch('http://localhost:9001/workspace/delete/?id='+ id, {
            method:'DELETE',
            mode: 'cors',
            body: JSON.stringify(workspace),
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
             }

    }).then(() => history.replace('/workspaces'));
}

    return (
        <DeleteWorkspaceForm  DeleteWorkspace ={DeleteWorkspaceHandler}/>
    );


};

export default DeleteWorkspace;
