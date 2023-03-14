const form = document.getElementById('payee-form');
const errorMessage = document.getElementById('error-message');

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const cust_name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const acctnum = document.getElementById('acctnum').value.trim();
  const ifsc=document.getElementById('ifsc').value.trim();

  if (!cust_name || !email || !acctnum ||!ifsc) {
    errorMessage.textContent = 'Please fill in all fields.';
    return;
  }

  if (!isValidEmail(email)) {
    errorMessage.textContent = 'enter a valid email address.';
    return;
  }

  if (!isValidAccountNumber(acctnum)) {
    errorMessage.textContent = ' enter a valid account number.';
    return;
  }

  //  we can submit the form
  form.submit();
});

function isValidEmail(email) {
  // email validation using a regex
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

function isValidAccountNumber(acctnum) {
  // Basic account number validation 
  const regex = /^[0-9]+$/;
  return regex.test(accountNumber);
}