<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bank.model.Customer" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Page</title>
    <link rel="stylesheet" type="text/css" href="static/css/Styles.css">
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

HttpSession ses = request.getSession(false);
if (session == null){
    // Redirect to login page if no session is found
    response.sendRedirect("index.jsp");
    return;
}

Customer customer = (Customer) request.getAttribute("customer");

if (customer != null) {
    String fullname = customer.getFullname();
    String gender = customer.getGender();
    String dob = customer.getDob();
    String email = customer.getEmail();
    String address = customer.getAddress();
    String username = customer.getUsername();
    String password = customer.getPassword();
    long adharnumber = customer.getAdharnumber();
    long phonenumber = customer.getPhonenumber();
    float balance = customer.getBalance();
    int accountNumber = customer.getAccno();
%>
<h1 style="color:red">Welcome <%= fullname %> to Btech Bank of India (BBI)</h1>
<p><%=request.getAttribute("result") %></p>
<div id="profile">
        <p>Full Name: <%= fullname %></p>
        <p>Account Number: <%= accountNumber %></p>
        <p>Email: <%= email %></p>
        <p>Username: <%= username %></p>
        <p>Password: <%= password %></p>
        <p>Aadhar Number: <%= adharnumber %></p>
        <p>Phone Number: <%= phonenumber %></p>
        <p>Balance: <%= balance %></p>
</div>  
  <div id="buttonsOp"> 
 
       <button onclick="showDepositForm(<%= accountNumber %>)">
  <span class="transition"></span>
  <span class="gradient"></span>
  <span class="label">Deposit</span>
</button>

<button onclick="showWithdrawForm(<%= accountNumber %>)">
  <span class="transition"></span>
  <span class="gradient"></span>
  <span class="label">Withdraw</span>
</button>

<button onclick="showTransferForm(<%= accountNumber %>)">
  <span class="transition"></span>
  <span class="gradient"></span>
  <span class="label">Transfer</span>
</button>

<button onclick="showUpdateForm(<%= accountNumber %>)">
 <span class="transition"></span>
 <span class="gradient"></span>
 <span class="label">Update</span>
</button> 
<div id="logoutbutton">
  <form action="logout" method="post">
    <button type="submit">Logout</button>
</form>
  </div> 
  </div> 
  
       
<%
}
else {
    out.println("No customer data found."); // Or handle this case appropriately
}

// Clear the session attribute for the last operation to prevent re-execution on page refresh
session.removeAttribute("lastOperation");
%>

<!-- Deposit Form -->
<div id="depositForm" style="display: none;">
    <form action="Deposit" method="post">
        <input type="hidden" name="accountNumber" id="depositAccountNumber" value="<%= customer.getAccno() %>">
        Enter amount to deposit: <input type="text" name="amount" required><br><br>
        <button type="submit">Confirm</button>
    </form>
</div>

<!-- Withdraw Form -->
<div id="withdrawForm" style="display: none;">
    <form action="Withdraw" method="post">
        <input type="hidden" name="accountNumber" id="withdrawAccountNumber" value="<%= customer.getAccno() %>">
        Enter amount to withdraw: <input type="text" name="amount" required><br><br>
        <button type="submit">Confirm</button>
    </form>
</div>

<!-- Transfer Form -->
<div id="transferForm" style="display: none;">
    <form action="Transfer" method="post">
        <input type="hidden" name="accountNumber" id="transferAccountNumber" value="<%= customer.getAccno() %>">
        Enter amount to transfer: <input type="text" name="amount" required><br>
        Enter Receiver Account Number: <input type="text" name="receiverAccno" required><br><br>
        <button type="submit">Confirm</button>
    </form>
</div>

<!-- Update Form -->
<div id="updateForm" style="display: none;">
    <form action="Update" method="post">
        <input type="hidden" name="accountNumber" id="updateAccountNumber" value="<%= customer.getAccno() %>">
        <label>Full Name</label>
        <input type="text" name="fullname" value="<%= customer.getFullname() %>" required><br><br>
        <label>DOB</label>
        <input type="text" name="dob" value="<%= customer.getDob() %>" required><br><br>
        <label>Email</label>
        <input type="email" name="email" value="<%= customer.getEmail() %>" required><br><br>
        <label>Aadhar Number</label>
        <input type="text" name="adharnumber" value="<%= customer.getAdharnumber() %>" required><br><br>
        <label>Phone Number</label>
        <input type="text" name="phonenumber" value="<%= customer.getPhonenumber() %>" required><br><br>
        <label>Address</label>
        <input type="text" name="address" value="<%= customer.getAddress() %>" required><br><br>
        <label>Username</label>
        <input type="text" name="username" value="<%= customer.getUsername() %>" required><br><br>
        <label>Password</label>
        <input type="password" name="password" value="<%= customer.getPassword() %>" required><br><br>
        <button type="submit">Confirm</button>
    </form>
</div>
<script>
    function showDepositForm(accountNumber) {
        document.getElementById('depositAccountNumber').value = accountNumber;
        showForm('depositForm');
    }

    function showWithdrawForm(accountNumber) {
        document.getElementById('withdrawAccountNumber').value = accountNumber;
        showForm('withdrawForm');
    }

    function showTransferForm(accountNumber) {
        document.getElementById('transferAccountNumber').value = accountNumber;
        showForm('transferForm');
    }

    function showUpdateForm(accountNumber) {
        document.getElementById('updateAccountNumber').value = accountNumber;
        showForm('updateForm');
    }

    function showForm(formId) {
        document.querySelectorAll('div[id$="Form"]').forEach(form => form.style.display = 'none');
        document.getElementById(formId).style.display = 'block';
    }
</script>
</body>
</html>
