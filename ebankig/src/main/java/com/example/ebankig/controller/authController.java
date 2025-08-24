/* @RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;
    private final EmailService emailService;

    public AuthController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String code = userService.generateResetCode(email);

        if (code == null) {
            return ResponseEntity.badRequest().body("Email introuvable !");
        }

        emailService.sendEmail(email, "Code de réinitialisation", "Votre code est : " + code);

        return ResponseEntity.ok("Code envoyé à " + email);
    }
}
 */