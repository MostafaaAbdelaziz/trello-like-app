import { Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function SetDueDateForm(props) {
    const [dueDate, setDueDateConst] = useState(new Date());


    function SetDueDate(e) {
        e.preventDefault();

        const taskDueDate = {
            taskDueDate: dueDate.getDate() + "-" + (dueDate.getMonth() + 1) + "-" + dueDate.getFullYear()
        };
        props.SetDueDate(taskDueDate);
    };

    return (
        <section>
            <div align= "left">
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    <Link to = "/tasks" style={{textDecoration: 'none', color: 'white'}}>Back to my Tasks</Link>
                </Button>
            </div>
            <form onSubmit={SetDueDate}>
                <h1>Please set the due date to one of the following :</h1>
                <DatePicker
                    selected={dueDate}
                    onChange={
                        (date:Date) => setDueDateConst(date)
                    }
                />
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Set Due Date
                </Button>
                <br></br>
            </form>
            
        </section>
    );
}
export default SetDueDateForm;
