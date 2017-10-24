#include <time.h>
#ifndef TIMER_H
#define TIMER_H


class Timer
{
    public:
        /**
        * Returns the time in seconds passed since Timer
        * was constructed.
        */
        double getTimePassed()
        {
            return difftime(time(NULL), startTime);
        }
        /**
        * Returns the time in seconds passed between when
        * Timer was constructed and given input time_t.
        * @arg time_t endTime the time used to compare
        */
        double getTimePassed(time_t endTime)
        {
            return difftime(endTime, startTime);
        }
        /**
        * Returns the time in seconds passed between
        * two inputted time_t
        * @arg time_t endTime the time used to compare
        */
        double getTimePassed(time_t beginTime, time_t endTime)
        {
            return difftime(endTime, beginTime);
        }
        /**
        * Returns the time_t that represents the inputted
        * number of seconds after the Timer started.
        * @arg time_t endTime the time used to compare
        */
        double getTimePassed(double timeElapsed)
        {
            time_t newTime = startTime + (int) timeElapsed;
            return newTime;
        }
        /**
        *  Returns the current time. Use getTimePassed
        *  to get the time between the start of the
        *  timer and this time.
        */
        time_t getCurrentTime()
        {
            return time(NULL);
        }
        /**
        *  Creates a timer to be used to organize
        *  time-based events.
        */
        Timer()
        {
            startTime = time(NULL);
        }
    protected:
    private:
        time_t startTime = time(NULL);
};

#endif // TIMER_H
