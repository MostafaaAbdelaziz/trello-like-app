import React from "react";
import { useHistory } from 'react-router-dom';
import DeleteBoardForm from "../components/DeleteBoardForm";


function DeleteBoard()  {
    const history = useHistory();
    function DeleteBoardHandler(board) {
        //the below loc is where I want to dump the data
        let id = history.location.pathname.split('/')[2];

        
            fetch('http://localhost:9001/board/delete/?id='+ id, {
                method:'DELETE',
                mode: 'cors',
                body: JSON.stringify(board),
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
             }

    }
    ).then(() => history.replace('/boards'));
}



    return (
        <DeleteBoardForm  DeleteBoard ={DeleteBoardHandler}/>
        
    );


};

export default DeleteBoard;
