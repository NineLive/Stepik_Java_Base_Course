package Module4_3;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task4_3_2 {

    public void start() {
        Inspector inspector = new Inspector();
        Thief thief = new Thief(100);
        Package content = new Package(WEAPONS, 10);
        Package content2 = new Package(BANNED_SUBSTANCE, 150);
        Package content3 = new Package("stones", 1);

        MailPackage mailPackage = new MailPackage("Terrorist", "Abdula", content);
        MailPackage mailPackage2 = new MailPackage("Terrorist", "Abdula", content2);
        MailPackage mailPackage3 = new MailPackage("Terrorist", "Abdula", content3);
//        inspector.processMail(mailPackage);
//        inspector.processMail(mailPackage2);
//        inspector.processMail(mailPackage3);

        var mailTH1 = thief.processMail(mailPackage);
        var mailTH2 = thief.processMail(mailPackage2);
        var mailTH3 = thief.processMail(mailPackage3);
//        ((MailPackage) mail).getContent().getPrice()
        System.out.println("first pack price: " + ((MailPackage) mailTH1).getContent().getPrice());
        System.out.println("first pack price: " + ((MailPackage) mailTH2).getContent().getPrice());
        System.out.println("first pack price: " + ((MailPackage) mailTH3).getContent().getPrice());


    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static interface Sendable {
        String getFrom();

        String getTo();
    }


    public static interface MailService {
        Sendable processMail(Sendable mail);
    }


    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
//========================================================================================

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }


    }

    //========================================================================================
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    //========================================================================================
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }


    //========================================================================================
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }


//========================================================================================


    public static class UntrustworthyMailWorker implements MailService {
        RealMailService realMailService = new RealMailService();
        MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService mailService : mailServices) {
                mail = mailService.processMail(mail);
            }

            return realMailService.processMail(mail);
        }
    }
//========================================================================================

    public static class Spy implements MailService {
        Logger LOGGER;

        public Spy(Logger LOGGER) {
            this.LOGGER = LOGGER;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailMessage) {
                String sender = mail.getFrom();
                String receiver = mail.getTo();

                if (Objects.equals(sender, AUSTIN_POWERS) | Objects.equals(receiver, AUSTIN_POWERS)) {
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{sender, receiver, ((MailMessage) mail).getMessage()});
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{sender, receiver});
                }


            }
            return mail;
        }
    }
//========================================================================================

    public static class Thief implements MailService {
        int minCost;
        int sumStolen = 0;

        public Thief(int minCost) {
            this.minCost = minCost;
        }

        public int getStolenValue() {
            return sumStolen;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            /**
             * the method returns a new MailPackage with 0 price and a formatted string if the old price is higher than the minCost
             */
            if (mail instanceof MailPackage) {

                int priceTakenPackage = ((MailPackage) mail).getContent().getPrice(); //take price from Package
                String contentOldPackage = ((MailPackage) mail).getContent().getContent();//take content from Package

                if (priceTakenPackage >= minCost) {
                    String newContentPackage = String.format("stones instead of {%s}", contentOldPackage);
                    MailPackage newPackage = new MailPackage(mail.getFrom(), mail.getTo(), new Package(newContentPackage, 0));
                    sumStolen += priceTakenPackage;
                    return newPackage;
                }

            }
            return mail;
        }
    }

    //========================================================================================
    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                String contentInPackage = ((MailPackage) mail).getContent().getContent();
                switch (contentInPackage) {
                    case WEAPONS:
                        throw new IllegalPackageException();
                    case BANNED_SUBSTANCE:
                        throw new IllegalPackageException();
                    case "stones":
                        throw new StolenPackageException();
                }
                if (contentInPackage.contains("stones")) {
                    throw new StolenPackageException();
                }

            }


            return null;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }
}


