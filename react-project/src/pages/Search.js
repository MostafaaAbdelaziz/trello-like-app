import {useEffect} from 'react';
import {useState} from 'react';

function getFilterdTasks(searchTerm) {
    fetch('http://localhost:9001/task/getSearchedTasks/?=' + searchTerm)
        .then(response => response.json())
        .then(tasks => {
            setTasksData(tasks);
        });
}
useEffect(function () {
    getFilterdTasks(searchTerm);
}
, [searchTerm]);