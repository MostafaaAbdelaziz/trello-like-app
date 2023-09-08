package com.csci3130_group11.group11_spring_boot.workspace.serviceImplementation;
import com.csci3130_group11.group11_spring_boot.workspace.model.WorkspaceModel;
import com.csci3130_group11.group11_spring_boot.workspace.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceServiceImp {
    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<WorkspaceModel> getAllWorkspace() {
        return workspaceRepository.findAll();
    }

    public WorkspaceModel updateWorkspace(WorkspaceModel workspace, int id)  {
        Optional<WorkspaceModel> findWorkspace = workspaceRepository.findById(id);
        if(findWorkspace.isPresent()) {
            findWorkspace.get().setWorkspaceName(workspace.getWorkspaceName());
            findWorkspace.get().setDescription(workspace.getDescription());
            workspaceRepository.save(findWorkspace.get());
            return findWorkspace.get();
        }
        return new WorkspaceModel();
    }

    public Integer createWorkspace(WorkspaceModel workspace) {
        return workspaceRepository.save(workspace).getId();
    }

    public WorkspaceModel saveWorkspace(WorkspaceModel workspace){
        workspace.setWorkspaceName(workspace.getWorkspaceName());
        workspace.setDescription(workspace.getDescription());
        return workspaceRepository.save(workspace);
    }
    public List<WorkspaceModel> getWorkspaces() {
        return workspaceRepository.findAll();
    }
    public WorkspaceModel deleteWorkspaceById(int id){
        Optional<WorkspaceModel> workspace = workspaceRepository.findById(id);
        if(workspace.isPresent()){
            workspaceRepository.deleteById(id);
            return workspace.get();
        }
        return new WorkspaceModel();
    }
    public WorkspaceModel getWorkspaceById(int id) {
        return workspaceRepository.findById(id).get();
    }

}
