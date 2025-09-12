import com.segment.analytics.Analytics
import com.segment.analytics.messages.IdentifyMessage

fun main() {
    val writeKey = "YOUR_WRITE_KEY" // Replace with your actual write key

    // Initialize Analytics client
    val analytics = Analytics.builder(writeKey).build()

    // Example PII object
    val pii = object {
        val adId = "user-1234"
    }

    // Example parameters (traits)
    val parameters = mapOf(
        "email" to "user@example.com",
        "name" to "John Doe"
    )

    // Send identify call
    analytics.enqueue(
        IdentifyMessage.builder()
            .userId(pii.adId)
            .traits(parameters)
    )

    // Optionally close to flush events (if used in a short-lived process)
    analytics.flush()
    analytics.shutdown()
}
