import React from "react";
import { useHistory } from "react-router-dom";
import SetDueDateForm from "../components/SetDueDateForm";

function SetDueDate() {
  const history = useHistory();
  let id = history.location.pathname.split("/")[2];

  function setDueDateHandler(dueDate) {
    fetch("http://localhost:9001/task/setDueDate/" + id, {
      method: "PUT",
      mode: "cors",
      body: JSON.stringify(dueDate),
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      }
    }).then(() => history.replace("/tasks"));
  }

  return (
    <SetDueDateForm SetDueDate={setDueDateHandler} />
  );
};
export default SetDueDate;