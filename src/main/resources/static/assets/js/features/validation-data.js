
// single submit(core for validation form)
const submitForm = function(formId, inputObj, callback){
    document.getElementById(formId).addEventListener('submit', function(e){
        e.preventDefault();

        const validationForm = validation(formId);
        const validObj = validationForm(inputObj);

        if(Object.keys(validObj.errorValidation).length === 0)
            e.target.submit();
        else{
            // create error message with dom or anythink
            // running callback
            callback(validObj.errorValidation);
        }
    })
}

// validation
const validation = function(formId){
    const myForm = document.getElementById(formId);

    return (inputObj) => {
        const handleInput = cachedMessageValidation(myForm);
        let errorValidation = {}

        for (const [id, type] of Object.entries(inputObj)) {            
            const statusInput = handleInput(id, type);

            if(!statusInput.isValid)
                errorValidation[id] = statusInput.messages
        }

        return {
            'errorValidation': errorValidation
        }
    }
}

const cachedMessageValidation = function(myForm){
    const inputNodelist = myForm.querySelectorAll("input");
    const inputAll = Array.from(inputNodelist).map(input => (input.id));

    return function(id, type){
        let messages = [];
        let isValid = true;
        
        if(inputAll.indexOf(id) === -1){
            messages.push(`${id} isn't available`)
            isValid = false;
        }else{
            let typesCategories = type.split('|');

            // check type(nnull -> not null)
            const value = document.getElementById(id).value;

            for (const t of typesCategories) {
                let catVal = categoryValidation(id, t, value);

                messages.push(catVal.message);

                if(!catVal.isValid && messages.length == 0)
                    isValid = false
            }
        }

        return {
            'isValid': isValid,
            'messages': messages
        }
    }
}

// Category validation
const categoryValidation = function(id ,type, value){
    let message = '';
    let isValid = true;

    let typeDetails = type.split(':');

    switch (typeDetails[0]) {
        case 'nnull':
            if(value.trim() === ""){
                message = `${id} is not null`;
                isValid = false;
            }
            break;
        case 'email':
            
            break;
        case 'lthan': // less than
            if(value.length < typeDetails[1]){
                message = `length ${id} less than ${typeDetails[1]}`;
                isValid = false;
            }
            break;
        case 'gthan': // greater than
            if(value.length > typeDetails[1]){
                message = `length ${id} greater than ${typeDetails[1]}`;
                isValid = false;
            }
            break;
        default:
            message = `${id} uses unused ${typeDetails[0]}`;
            isValid = false;
            break;
    }

    return {
        'message': message,
        'isValid': isValid
    }
}