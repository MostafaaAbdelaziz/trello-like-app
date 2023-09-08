import React from "react";
import {Route, Switch} from "react-router-dom";
import RegisterPage from "./pages/Register";
import LoginPage from "./pages/Login";
import HomePage from "./pages/Home";
import NavigationLogin from "./components/NavigationLogin";
import NavigationHome from "./components/NavigationHome";
import ForgetPassPage from "./pages/ForgetPass";
import WorkspacePage from "./pages/Workspace";
import Boards from "./pages/Boards";
import CreateBoard from "./pages/CreateBoard";
import DeleteBoard from "./pages/DeleteBoard";
import CreateWorkspace from "./pages/CreateWorkspace";
import DeleteWorkspace from "./pages/DeleteWorkspace";
import AssignTaskToUser from "./pages/AssignTaskToUser";
import ViewTasks from "./pages/Task";
import CreateTask from "./pages/CreateTask";
import DeleteTask from "./pages/DeleteTask";
import UpdateTaskStatus from "./pages/UpdateTaskStatus";
import SetDueDate from "./pages/SetDueDate";
import SearchTask from "./pages/SearchTask";

function App() {
  // const [jwt, setJwt] = useLocalState("", "jwt");
  return(
    <div>
        {/* <Route path="/workspace">
          <WorkspacePage/>
        </Route> */}

        { ( localStorage.getItem("user") === "Authenticated" ) ? 
        <Switch>        
        <Route path="/home">
        <NavigationHome/>
          <HomePage/>
        </Route>
        <Route path="/boards">
        <NavigationHome/>
        <Boards/>
        </Route>
        <Route path="/create-board">
        <NavigationHome/>
          <CreateBoard />
        </Route>
        <Route path="/delete-board">
        <NavigationHome/>
          <DeleteBoard />
        </Route>
        <Route path="/workspaces">
        <NavigationHome/>
          <WorkspacePage/>
        </Route>
        <Route path ="/create-workspace">
        <NavigationHome/>
          <CreateWorkspace/>
        </Route>
        <Route path = "/delete-workspace">
        <NavigationHome/>
          <DeleteWorkspace/>
        </Route>

        <Route path = "/assign-task-to-user/:id">
        <NavigationHome/>
          <AssignTaskToUser />
        </Route>

        <Route path = "/tasks">
        <NavigationHome/>
          <ViewTasks />
        </Route>

        <Route path = "/create-task">
        <NavigationHome/>
          <CreateTask />
        </Route>

        <Route path ="/delete-task">
        <NavigationHome/>
          <DeleteTask />
        </Route>

       <Route path ="/update-task/:id">
        <NavigationHome/>
          <UpdateTaskStatus />
        </Route>

        <Route path ="/set-due-date/:id">
        <NavigationHome/>
          <SetDueDate />
        </Route>

        <Route path ="/search-task">
        <NavigationHome/>
          <SearchTask />
        </Route>

        </Switch>
        : 
        <Switch>

        <Route path="/forgetpass">
        <NavigationLogin/>
          <ForgetPassPage/>
        </Route>

        <Route path="/register">
          <NavigationLogin />
          <RegisterPage/>
        </Route> 

        <Route path={["/" , "/login"]} exact>
        <NavigationLogin/>
          <LoginPage/>
        </Route>

        </Switch> }
        

    </div>
  );  
}

export default App;

/*
      <Switch>



        <Route path={["/" , "/login"]} exact>
        <NavigationLogin />
          <LoginPage/>
        </Route>

        <Route path="/forgetpass">
        <NavigationLogin />
          <ForgetPassPage/>
        </Route>

        <Route path="/home">
          <HomePage/>
        </Route>
        <Route path="/boards">
        <Boards/>
        </Route>
        <Route path="/create-board">
          <CreateBoard />
        </Route>
        </Switch>
*/
