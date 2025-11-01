<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GrandView Hotel Management</title>
    <style>
        /* Global reset & typography */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
            line-height: 1.6;
        }
        a {
            text-decoration: none;
            color: inherit;
        }
        h1, h2 {
            color: #003366;
        }

        /* Navbar */
        nav {
            background: #003366;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem 2rem;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        nav .logo {
            font-size: 1.5rem;
            font-weight: bold;
            letter-spacing: 1px;
        }
        nav ul {
            list-style: none;
            display: flex;
            gap: 1.5rem;
        }
        nav ul li a {
            color: #fff;
            font-weight: 500;
            transition: color 0.3s ease;
        }
        nav ul li a:hover {
            color: #f0c14b;
        }

        /* Hero section */
        .hero {
            background: url('https://images.unsplash.com/photo-1501117716987-c8e99b6a7eaf?auto=format&fit=crop&w=1500&q=80') center/cover no-repeat;
            color: #fff;
            height: 60vh;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            padding: 2rem;
            box-shadow: inset 0 0 0 2000px rgba(0,0,0,0.4);
        }
        .hero h1 {
            font-size: 3rem;
            margin-bottom: 1rem;
        }
        .hero p {
            font-size: 1.2rem;
        }

        /* Main content */
        .content {
            padding: 3rem 2rem;
            max-width: 1100px;
            margin: auto;
        }
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 1.5rem;
            margin-top: 2rem;
        }
        .card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            overflow: hidden;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }
        .card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
        }
        .card-body {
            padding: 1rem;
        }
        .card-body h3 {
            margin-bottom: 0.5rem;
        }
        .card-body p {
            color: #666;
            font-size: 0.9rem;
        }

        /* Footer */
        footer {
            background: #003366;
            color: #fff;
            text-align: center;
            padding: 1rem;
            margin-top: 3rem;
        }

        /* Button styles */
        .btn {
            display: inline-block;
            background: #003366;
            color: #fff;
            padding: 0.6rem 1.2rem;
            border-radius: 5px;
            margin-top: 0.5rem;
            transition: background 0.3s ease;
        }
        .btn:hover {
            background: #f0c14b;
            color: #003366;
        }
    </style>
</head>
<body>

<nav>
    <div class="logo">GrandView Hotel</div>
    <ul>
        <li><a href="rooms">Rooms</a></li>
        <li><a href="guests">Guests</a></li>
        <li><a href="bookings">Bookings</a></li>
    </ul>
</nav>

<section class="hero">
    <div>
        <h1>Welcome to GrandView Hotel</h1>
        <p>Experience comfort, elegance, and modern hospitality management.</p>
        <p><a class="btn" href="rooms">Explore Our Rooms</a></p>
    </div>
</section>

<section class="content">
    <h2>Our Featured Rooms</h2>
    <div class="grid">
        <div class="card">
            <img src="https://images.unsplash.com/photo-1560185127-6ed189bf02f4?auto=format&fit=crop&w=800&q=80" alt="Single Room">
            <div class="card-body">
                <h3>Single Room</h3>
                <p>Perfect for solo travelers. Comfortable bed, workspace, and city view.</p>
                <a class="btn" href="rooms">View Details</a>
            </div>
        </div>
        <div class="card">
            <img src="https://images.unsplash.com/photo-1600585154340-be6161a56a0c?auto=format&fit=crop&w=800&q=80" alt="Double Room">
            <div class="card-body">
                <h3>Double Room</h3>
                <p>Ideal for couples or friends. Spacious layout with modern amenities.</p>
                <a class="btn" href="rooms">View Details</a>
            </div>
        </div>
        <div class="card">
            <img src="https://images.unsplash.com/photo-1618773928121-c32242e63f6c?auto=format&fit=crop&w=800&q=80" alt="Luxury Suite">
            <div class="card-body">
                <h3>Luxury Suite</h3>
                <p>Indulge in luxury with premium furnishing, balcony, and sea view.</p>
                <a class="btn" href="rooms">View Details</a>
            </div>
        </div>
    </div>
</section>

<footer>
    <p>&copy; <%= java.time.Year.now() %> GrandView Hotel Management System. All Rights Reserved.</p>
</footer>

</body>
</html>
