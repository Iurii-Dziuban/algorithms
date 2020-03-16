package iurii.job.interview.booking_com.on_site;

/**
 * On site interview consists of 4 parts. 3 standard for booking.com and 1 for the payment team in booking.com
 *
 * 1) Algorithms.
 *    1.1 There are in-out days of trips. Group in-outs into continuous trips
 *    1.2 Find if word exists in 2D Grid of characters (No cycles are possible). All 8 nearest cells are possible to move to
 * 2) Design
 *    There are many servers - each of them send event of server state (on some actions)
 *    Graphics of total health should be shown to the monitoring team in real time
 *    Each event is in the format of json :
 *
 *    Key things to mention: load balancer, document base database (like mongo db)
 *
 * 3) Commercial Awareness / Cultural fit interview
 *    Questions:
 *    1) What was the task you completed and were you most proud of
 *    2) How were you solving conflicts with team mates?
 *    3) What would you change on Booking.com site and how would you measure if it makes site better?
 *    4) Which hotels/motels/apartments will you on board first? Small/big geographically close/far
 * All answers should reflect A/B testing approach, data-driven approach in developing functionality,
 * implementations should be customer oriented (not manager, etc.)
 * 4) Payments team interview
 *    Interview about payments itself. Pre authentication, Authentication, Capture, Purchase, Refund, Reversals.
 *    Knowing data policies like PCI compliance, GDPR, etc.
 *    Components - issuing bank, acquirer bank, psp (payment service provider), billing and invoice generations,
 *    fx exchange, card type service (for card payments), credit restrictions (limits)
 *    Knowing how 3D secure works.
 *    Online payments / offline payments (in the end of the day with batches with aggregations of payments
 *    - to save number of transactions therefore costs)
 *
 */
public class OnSite {


}
