# Software-Security
Portfolio work for CS-305 Software Security at SNHU
# Software Security – Portfolio Artifact (CS-305)

**Artifact:** Artemis Financial – Practices for Secure Software Report (Project Two)  
**Author:** Nicholas Justus  
**Course:** CS-305 Software Security @ SNHU

---

## Client & Software Requirements
Artemis Financial is a financial planning firm with a public web app for customers. They asked me to modernize the app’s security with a file verification step (checksum) and to ensure the app served traffic over HTTPS using a server certificate. In short, I needed to add a secure hashing workflow, enable TLS, and verify that my changes didn’t introduce new vulnerabilities.

## What I Did Well & Why Secure Coding Matters
I implemented a SHA-256 checksum endpoint and configured Spring Boot/Tomcat to use TLS on port 8443 with a PKCS#12 keystore. I liked that I kept the changes small and well-scoped (clean controller, simple application properties). Secure coding matters because it protects customer data, reduces legal and operational risk, and builds trust. For a financial company, even small flaws can have big consequences.

## Challenging/Helpful Parts of the Vulnerability Assessment
The OWASP Dependency-Check report was both helpful and noisy. It flagged many transitive dependencies from Spring. The challenge was staying focused on my changes and understanding that I don’t “fix” the whole framework; I document the results, suppress obvious false positives when appropriate, and avoid introducing vulnerable libraries myself.

## How I Increased Layers of Security
- **Transport security:** Converted HTTP to **HTTPS** with a self-signed cert loaded via Spring Boot’s `server.ssl.*` settings.  
- **Data integrity:** Added a **SHA-256** checksum endpoint that returns a digest for a unique data string.  
- **Build-time checks:** Integrated **OWASP Dependency-Check** to statically scan dependencies.

In the future I’d add Snyk or GitHub Dependabot for continuous monitoring, use OWASP ZAP for dynamic testing, and consider a Web Application Firewall, CSP headers, and stricter TLS ciphersuites.

## Verifying Functionality & That I Didn’t Add New Vulnerabilities
I ran the application locally and verified:
- `https://localhost:8443/hash` loaded over HTTPS (certificate trusted locally)  
- The endpoint returned my name, the string, and a SHA-256 hash

Then I ran OWASP Dependency-Check and reviewed the report to ensure my refactor didn’t add risky libraries. If anything popped up related to my changes, I would pin versions or switch dependencies.

## Tools, Resources, and Practices I’ll Reuse
- **Spring Boot/Tomcat TLS** configuration with PKCS#12 keystores  
- **Java Keytool** for creating self-signed certs  
- **OWASP Dependency-Check** for static dependency analysis  
- Keeping changes small, tested, and well-documented; using meaningful commit messages

## What I Can Show Employers
I can show the repo with:
- The **secure hashing endpoint** & HTTPS configuration
- **Dependency-Check report** screenshot/output
- The **Practices for Secure Software Report** documenting my approach

This demonstrates I can read requirements, implement secure communication, verify integrity with hashing, and use industry tools to validate my work.
