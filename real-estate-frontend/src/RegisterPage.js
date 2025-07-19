import React, { useState } from "react";
import axios from "axios";

function RegisterPage() {
  const [form, setForm] = useState({
    email: "",
    full_name: "",
    password: "",
  });

  const [message, setMessage] = useState("");
  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const nameRegex = /^[A-Za-z ]+$/;
    const passwordRegex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    if (!form.email || !emailRegex.test(form.email)) {
      newErrors.email = "Invalid email format";
    }
    if (!form.full_name || !nameRegex.test(form.full_name)) {
      newErrors.full_name = "Name must contain only letters and spaces";
    }
    if (!form.password || !passwordRegex.test(form.password)) {
      newErrors.password =
        "Password must contain lowercase, uppercase, digit, special char, and be 8+ characters long";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validate()) return;

    try {
      await axios.post("http://localhost:8080/broker/register", form);
      setMessage("✅ Registered successfully!");
      setForm({ email: "", full_name: "", password: "" });
    } catch (err) {
      if (err.response && err.response.data) {
        setMessage("❌ " + err.response.data.message);
      } else {
        setMessage("❌ Error registering user.");
      }
    }
  };

  return (
    <div style={{ maxWidth: "400px", margin: "auto", padding: "2rem" }}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Email:</label><br />
          <input
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
          />
          <div style={{ color: "red" }}>{errors.email}</div>
        </div>
        <br />
        <div>
          <label>Full Name:</label><br />
          <input
            type="text"
            name="full_name"
            value={form.full_name}
            onChange={handleChange}
          />
          <div style={{ color: "red" }}>{errors.full_name}</div>
        </div>
        <br />
        <div>
          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
          />
          <div style={{ color: "red" }}>{errors.password}</div>
        </div>
        <br />
        <button type="submit">Register</button>
      </form>
      <p style={{ color: "green" }}>{message}</p>
    </div>
  );
}

export default RegisterPage;