import React, { useEffect, useState } from 'react';
import ViewWorkspaces from '../components/ViewWorkspaces';

function Workspaces() {
    const [WorkspacesData, setWorkspacesData] = useState([]);

    function getAllWorkspaces() {
        fetch('http://localhost:9001/workspace')
            .then(response => response.json())
            .then(workspaces => {
                setWorkspacesData(workspaces);
            });
    };

    useEffect(function () {
        getAllWorkspaces();
    }, []);


    return (
        <section>
            <ViewWorkspaces workspaces={WorkspacesData} />
        </section>
    );

};
export default Workspaces;