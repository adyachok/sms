I decided to go DDD way

Introduced models User, Phone - aggregate
    Message, ReceiverType
    and SMS service

Tried to write tests but stacked with singleton,
 it seams it wasn't removed from cache.