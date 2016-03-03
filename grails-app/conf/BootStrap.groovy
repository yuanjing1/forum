import org.csisd.forum.Comment
import org.csisd.forum.DiscussionThread
import org.csisd.forum.Section
import org.csisd.forum.Topic
import org.csisd.user.Role
import org.csisd.user.User
import org.csisd.user.UserRole

class BootStrap {

    def random = new Random();
    def words = ("time,person,year,way,day,thing,man,world,life,hand,part,child,eye,woman,place,work,week,case,point," +
            "government,company,number,group,problem,fact,be,have,do,say,get,make,go,know,take,see,come,think,look," +
            "want,give,use,find,tell,ask,work,seem,feel,try,leave,call,good,new,first,last,long,great,little,own," +
            "other,old,right,big,high,different,small,large,next,early,young,important,few,public,bad,same,able,to,of," +
            "in,for,on,with,at,by,from,up,about,into,over,after,beneath,under,above,the,and,a,that,I,it,not,he,as,you," +
            "this,but,his,they,her,she,or,an,will,my,one,all,would,there,their").split(",")

    private String generateRandomComment() {
        def numberOfWords = random.nextInt(50) + 15
        StringBuilder sb = new StringBuilder()
        numberOfWords.times {
            def randomWord = words[random.nextInt(words.length)]
            sb.append("${randomWord} ")
        }
        return sb.toString()
    }

    def init = { servletContext ->

        User admin = new User(username:'admin', password:'admin', email:'yuanjing.xu@gmail.com', enabled:true).save()
        User Serena = new User(username:'serena', password:'serena', email:'serenalwang@yahoo.com', enabled:true).save()
        User Woody = new User(username:'woody', password:'woody',  email:'woodywang153@gmail.com',enabled:true).save()
        User Rosetta = new User(username:'rosetta', password:'rosetta', email:'rosettawang@gmail.com', enabled:true).save()
        Role roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
        Role roleUser = new Role(authority: 'ROLE_USER').save()
        UserRole.create admin, roleAdmin
        UserRole.create Serena, roleUser
        UserRole.create Woody, roleUser
        UserRole.create Rosetta, roleUser

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        if ( Section.count() == 0 ) { // create data if no forum data found
            // get all users
            def users = User.list()
            // create 3 sections
            def section = new Section(title: 'Sports').save()
            def topic = new Topic(section: section, title: 'Cross Country', description: 'Running').save()
            def thread = new DiscussionThread(topic:topic, subject:'Next Meet', opener:Rosetta).save()
            topic = new Topic(section: section, title: 'Hockey', description: 'Brazos Valley Team Storm').save()

            section = new Section(title: 'Computer Science').save()
            topic = new Topic(section: section, title: 'Grails', description: 'Web Application Framework').save()
            thread = new DiscussionThread(topic:topic, subject:'Plugins', opener:Woody).save()
            thread = new DiscussionThread(topic:topic, subject:'Security', opener:Serena).save()
            topic = new Topic(section: section, title: 'JQuery', description: 'Javascript Library').save()

            section = new Section(title: 'Biology').save()
            topic = new Topic(section: section, title: 'Birds', description: 'Parrots Research').save()
            thread = new DiscussionThread(topic:topic, subject:'Why Parrots Eat Soil', opener:Rosetta).save()
            topic = new Topic(section: section, title: 'Dogs', description: 'Aggie Guide-Dogs and Service-Dogs').save()
            /*
            ('A'..'C').each { sectionLetter ->
                def sectionTitle = "Section ${sectionLetter}"
                def section = new Section(title: sectionTitle).save()
                // create 4 topics per section
                (1..4).each { topicNumber ->
                    def topicTitle = "Topic ${sectionLetter}-${topicNumber}"
                    def topicDescription = "Description of ${topicTitle}"
                    def topic = new Topic(section: section, title: topicTitle, description: topicDescription).save()
                    // create 10-20 threads each topic
                    def numberOfThreads = random.nextInt(11)+10
                    (1..numberOfThreads).each { threadNo ->
                        def opener = users[random.nextInt(100)]
                        def subject = "Subject ${sectionLetter}-${topicNumber}-${threadNo} "
                        def thread = new DiscussionThread(topic:topic, subject:subject, opener:opener).save()
                        new Comment(thread:thread, commentBy:opener, body:generateRandomComment()).save()
                        // create 10-35 replies per thread
                        def numberOfReplies = random.nextInt(26)+10
                        numberOfReplies.times {
                            def commentBy = users[random.nextInt(100)]
                            new Comment(thread:thread, commentBy:commentBy, body:generateRandomComment()).save()
                        }
                    }
                }
            }*/
        }

        //assert User.count() == 2
        assert Role.count() == 2
        //assert UserRole.count() == 2
    }
    def destroy = {
    }
}
