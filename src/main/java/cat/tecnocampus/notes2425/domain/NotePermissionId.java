package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NotePermissionId implements Serializable {
    private Long noteId;
    private Long permissionId;

    public NotePermissionId() {}

    public NotePermissionId(Long noteId, Long permissionId) {
        this.noteId = noteId;
        this.permissionId = permissionId;
    }
    public Long getNoteId() {
        return noteId;
    }
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }
    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

}
