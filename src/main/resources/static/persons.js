function addNew() {
    const name = $('#modal-person-name').val();
    const address = $('#modal-person-address').val();
    const birthdate = $('#modal-person-birthdate').val();
    const type = $('#modal-membership-type').val();
    const membershipName = $('#modal-membership-membershipName').val();
    const validFrom = $('#modal-membership-validFrom').val();
    const validTo = $('#modal-membership-validTo').val();
    const gymName = $('#modal-gym-gymName').val();

    fetch('/api/memberships', {
        method: 'POST',
        body: JSON.stringify({
            type: type,
            membershipName: membershipName,
            validFrom: validFrom,
            validTo: validTo
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
             // addNew()
            location.reload()    // call person
        } else {
            alert()
        }
    });

    fetch('/api/gyms', {
        method: 'POST',
        body: JSON.stringify({
            gymName: gymName
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
            location.reload()
        } else {
            alert()
        }
    });

    fetch('/api/persons', {
        method: 'POST',
        body: JSON.stringify({
            name: name,
            address: address,
            birthdate: birthdate,
            type: type,
            membershipName: membershipName,
            validFrom: validFrom,
            validTo: validTo,
            gymName: gymName
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
            location.reload()
        } else {
            alert()
        }
    });
}

function editPerson(personIdToEdit) {
    const name = $('#modal-person-name').val();
    const address = $('#modal-person-address').val();
    const birthdate = $('#modal-person-birthdate').val();
    const membershipType = $('#modal-membership-membershipType').val();
    const validFrom = $('#modal-membership-validFrom').val();

    fetch('/api/persons/' + personIdToEdit, {
        method: 'PUT',
        body: JSON.stringify({
            name: name,
            address: address,
            birthdate: birthdate,
            membershipType: membershipType,
            validFrom: validFrom
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => location.reload());
}

function addPerson() {
    let personIdToEdit = null;
    if (personIdToEdit) {
        editPerson(personIdToEdit);
    } else {
        addNew();
    }
}

$(document).ready(() => {
    let personIdToEdit = null;

    $('#add-person-button').click(function () {
        if (personIdToEdit) {
            editPerson(personIdToEdit);
        } else {
            addNew();
        }
    });

    $('.fa-edit').click(function () {
        personIdToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const name = row.children[0].innerText;
        const address = row.children[1].innerText;
        const birthdate = row.children[2].innerText;
        const membershipType = row.children[3].innerText;
        const validFrom = row.children[4].innerText;

        $('#modal-person-name').val(name);
        $('#modal-person-address').val(address);
        $('#modal-person-birthdate').val(birthdate);
        $('#modal-membership-membershipType').val(membershipType);
        $('#modal-membership-membershipValidFrom').val(validFrom);
    });

    $('.fa-trash-alt').click(function () {
        var message = confirm("Are you sure you want to delete this person?");
        if (message) {
        const toDelete = this.parentElement.id;
        fetch('/api/persons/' + toDelete, {
            method: 'DELETE'
        }).then(response => location.reload());}

    });
});
