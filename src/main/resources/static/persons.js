function addNew() {
    const name = $('#modal-person-name').val();
    const address = $('#modal-person-address').val();
    const birthdate = $('#modal-person-birthdate').val();
    const type = $('#modal-membership-type');
    const validFrom = $('#modal-membership-validFrom');
    const validTo = $('#modal-membership-validTo');
    const gym = $('#modal-person-gym').val();   // only gymName

    fetch('/api/memberships', {
        method: 'POST',
        body: JSON.stringify({
            type: type,
            validFrom: validFrom,
            validTo: validTo
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
            validFrom: validFrom,
            validTo: validTo,
            gym: gym
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
    const membership = $('#modal-person-membership').val();

    fetch('/api/persons/' + personIdToEdit, {
        method: 'PUT',
        body: JSON.stringify({
            name: name,
            address: address,
            birthdate: birthdate,
            membership: membership
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => location.reload());
}

function addPerson() {
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
        const membership = row.children[3].innerText;

        $('#modal-person-name').val(name);
        $('#modal-person-address').val(address);
        $('#modal-person-birthdate').val(birthdate);
        $('#modal-person-membership').val(membership);
    });

    $('.fa-trash-alt').click(function () {
        const toDelete = this.parentElement.id;
        fetch('/api/persons/' + toDelete, {
            method: 'DELETE'
        }).then(response => location.reload());

    });
});
