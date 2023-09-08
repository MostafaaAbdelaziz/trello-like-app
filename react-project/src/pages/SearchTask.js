import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import SearchTaskForm from "../components/SearchTaskForm";
import {useState} from "react";
import ViewSearchTasks from "../components/ViewSearchTasks";
import { PlaylistAddCheckCircleRounded } from "@mui/icons-material";

function SearchTask() {
    const history = useHistory();
    const [tasksData, setTasksData] = useState([]);
    
    function searchTaskHandler(search) {
        fetch("http://localhost:9001/task/getAll" , {
            method: "Get",
            mode: "cors",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            }
        }).then(response => response.json())
        .then(tasks => {
            let filteredTasks = tasks.filter(task => {
                if(task.taskName.toLowerCase().includes(search.search.toString().toLowerCase())){
                    return task
                }
            });
            setTasksData(filteredTasks);
        });

    };
    useEffect(function () {
        searchTaskHandler();
    }, []);

    return (
        <>
        <SearchTaskForm SearchTask={searchTaskHandler} />
        <ViewSearchTasks tasks={tasksData} />
        </>
    ); 
}
export default SearchTask;